import React, { useState, useEffect } from 'react';
import axios from 'axios';

const OrganizationSelect = ({ handleSelect }) => {
  const [orgList, setOrgList] = useState([]);

  useEffect(() => {
    axios
      .get('http://localhost:9630/showOrg') // Fetch list of organizations
      .then((response) => {
        setOrgList(response.data);
      })
      .catch((error) => {
        console.error('Error fetching organizations:', error.message);
      });
  }, []);

  const handleChange = (event) => {
    const selectedOrgId = event.target.value;
    handleSelect(selectedOrgId); // Pass selected org ID back to parent component
  };

  return (
    <div>
      <select onChange={handleChange} defaultValue="">
        <option value="" disabled>
          Select an Organization
        </option>
        {orgList.map((org) => (
          <option key={org.id} value={org.id}>
            {org.name}
          </option>
        ))}
      </select>
    </div>
  );
};

export default OrganizationSelect;
