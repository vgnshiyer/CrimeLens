import { useState } from "react";
import {
  RadioGroup,
  List,
  ListItem,
  ListItemText,
  FormControl,
  // Radio,
  Typography,
  Select,
  MenuItem,
} from "@mui/material";
import { getFilteredDate } from "../utils/dateUtils";
import styled from "styled-components";

const ScrollableDiv = styled.div`
  height: 404;
  overflow: auto;

  &::-webkit-scrollbar {
    width: 5px;
    border-radius: 5px;
  }

  &::-webkit-scrollbar-track {
    background: #1e2735;
    border-radius: 5px;
  }

  &::-webkit-scrollbar-thumb {
    background: #426367;
    border-radius: 5px;
  }

  &::-webkit-scrollbar-thumb:hover {
    background: #1e2735;
  }
`;

export default function Filter({
  crimeTypes,
  setSelectedCrimeType,
  setCrimeDateFilter,
}) {

  const [selectedValue, setSelectedValue] = useState('All');

  const handleCrimeTypeChange = (value) => {
    setSelectedCrimeType(value === 'All' ? '' : value);
    setSelectedValue(value);
  };

  const handleDateFilterChange = (event) => {
    let formattedDate = getFilteredDate(event.target.value);
    setCrimeDateFilter(formattedDate);
  };


  return (
    <div>
      <div style={{ backgroundColor: '#1e2735', borderRadius: '15px', padding: '10px', marginTop: '55px', marginLeft: '15px' }}>
        <Typography variant="h6" component="h2" style={{ backgroundColor: '#1e2735', }}>
          Crime Type
        </Typography>
        <ScrollableDiv>
          <List>
            <ListItem button selected={selectedValue === 'All'} onClick={() => handleCrimeTypeChange('All')} style={selectedValue === 'All' ? { backgroundColor: '#3f51b563', color: '#fff', borderRadius: '20px' } : {}}>
              <ListItemText primary="All" />
            </ListItem>
            {crimeTypes.map((type, index) => (
              <ListItem
                button
                key={index}
                selected={selectedValue === type.label}

                onClick={() => handleCrimeTypeChange(type.label)}
                style={selectedValue === type.label ? { backgroundColor: '#3f51b563', color: '#fff', borderRadius: '20px' } : {}}
              >
                <ListItemText primary={type.label} />
              </ListItem>
            ))}
          </List>
        </ScrollableDiv>

        <br />
        <br />
        <br />
      </div>
      <div style={{ backgroundColor: '#1e2735', borderRadius: '15px', padding: '10px', marginTop: '10px', marginLeft: '15px' }}>
        <Typography variant="h6" component="h2" style={{ backgroundColor: '#1e2735', }}>
          Filter by Date
        </Typography>
        <FormControl style={{ marginTop: '15px' }} variant="standard">
          <Select style={{ color: '#fdf0d5', padding: '10px', backgroundColor: '#3f51b563', borderRadius: '20px' }} onChange={handleDateFilterChange} defaultValue="LAST_10_YEARS">
            <MenuItem value="LAST_7_DAYS">Last 7 Days</MenuItem>
            <MenuItem value="LAST_30_DAYS">Last 30 Days</MenuItem>
            <MenuItem value="LAST_180_DAYS">Last 90 Days</MenuItem>
            <MenuItem value="LAST_1_YEAR">Last 1 Year</MenuItem>
            <MenuItem value="LAST_5_YEARS">Last 5 Years</MenuItem>
            <MenuItem value="LAST_10_YEARS">Last 10 Years</MenuItem>
          </Select>
        </FormControl>
      </div>
    </div>
  );
}
