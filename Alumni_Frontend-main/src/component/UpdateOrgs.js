import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import axios from 'axios';
import FormControl from '@mui/material/FormControl';
import { Button, TextField } from '@mui/material';
import OrganizationSelect from './OrganizationSelect';

function UpdateOrgs() {
  const location = useLocation();
  const { id, alumni_id } = location.state || {};
  const url = `http://localhost:9630/updateAlumniOrg/`;

  const [resData, setResData] = useState({});
  const [organizations, setOrganizations] = useState([]);
  const [myData, setMyData] = useState({
    alumni_id: '',
    org_name: '',
    position: '',
    joiningDate: '',
    leavingDate: '',
  });

  // Handle the update button click
  const handleUpdateButton = () => {
    const data = {
      alumni_id: alumni_id,
      org_name: myData.org_name,
      position: myData.position,
      joiningDate: myData.joiningDate,
      leavingDate: myData.leavingDate,
    };

    axios
      .put(url, data)
      .then((response) => {
        console.log('Organization update successful', response.data);
      })
      .catch((error) => {
        console.error('Update failed:', error.message);
      });
  };

  // Fetch organization and alumni details on component mount
  useEffect(() => {
    if (id) {
      axios
        .get(`http://localhost:9630/getOrgDetailById/${id}`)
        .then((res) => {
          const fetchedData = res.data[0];
          setResData(fetchedData);
          setMyData({
            alumni_id: alumni_id,
            org_name: fetchedData.organisationName || '',
            position: fetchedData.position || '',
            joiningDate: fetchedData.joiningDate || '',
            leavingDate: fetchedData.leavingDate || '',
          });
        })
        .catch((error) => {
          console.error('Error fetching organization details:', error.message);
        });
    }

    axios
      .get('http://localhost:9630/getAllOrganizations')
      .then((response) => {
        setOrganizations(response.data);
      })
      .catch((error) => {
        console.error('Error fetching organizations:', error.message);
      });
  }, [id, alumni_id]);

  // Handle organization selection
  const handleOrganizationSelect = (selectedOrgId) => {
    const selectedOrg = organizations.find((org) => org.id === selectedOrgId);
    setMyData({
      ...myData,
      org_name: selectedOrg ? selectedOrg.name : '',
    });
  };

  return (
    <div className="updateProfile_div">
      <FormControl>
        {/* OrganizationSelect for selecting the organization */}
        <OrganizationSelect handleSelect={handleOrganizationSelect} />

        {/* Input fields for position, joining date, and leaving date */}
        <TextField
          id="position"
          label="Position"
          variant="standard"
          required
          margin="normal"
          placeholder="Enter Position"
          value={myData.position}
          onChange={(e) => setMyData({ ...myData, position: e.target.value })}
        />
        <TextField
          id="joiningDate"
          label="Joining Date"
          variant="standard"
          required
          margin="normal"
          placeholder="Enter Joining Date"
          value={myData.joiningDate}
          onChange={(e) => setMyData({ ...myData, joiningDate: e.target.value })}
        />
        <TextField
          id="leavingDate"
          label="Leaving Date"
          variant="standard"
          required
          margin="normal"
          placeholder="Enter Leaving Date"
          value={myData.leavingDate}
          onChange={(e) => setMyData({ ...myData, leavingDate: e.target.value })}
        />
        <Button margin="normal" onClick={handleUpdateButton}>
          Update
        </Button>
      </FormControl>
    </div>
  );
}

export default UpdateOrgs;
