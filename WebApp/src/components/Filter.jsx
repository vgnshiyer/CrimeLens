import React from "react";
import {
  RadioGroup,
  FormControlLabel,
  Radio,
  Typography,
  Select,
  MenuItem,
} from "@mui/material";
import { getFilteredDate } from "../utils/dateUtils";

export default function Filter({
  crimeTypes,
  setSelectedCrimeType,
  setCrimeDateFilter,
}) {
  const handleCrimeTypeChange = (event) => {
    setSelectedCrimeType(
      event.target.value === "ALL" ? "" : event.target.value
    );
  };

  const handleDateFilterChange = (event) => {
    let formattedDate = getFilteredDate(event.target.value);
    setCrimeDateFilter(formattedDate);
  };

  // TODO: Add colors to the list items
  const colors = ["red", "blue", "green", "yellow", "purple"];

  return (
    <div>
      <Typography variant="h6" component="h2" style={{ backgroundColor: 'rgba(255, 255, 255, 0.2)', }}>
        Filter by Crime
      </Typography>
      <RadioGroup onChange={handleCrimeTypeChange} defaultValue="ALL">
        <FormControlLabel value="ALL" control={<Radio />} label="ALL" />
        {crimeTypes.map((type, index) => (
          <FormControlLabel
            key={index}
            value={type.label}
            control={<Radio />}
            label={type.label}
            style={{ color: colors[index % colors.length] }}
          />
        ))}
      </RadioGroup>

      <br />
      <br />
      <br />
      <Typography variant="h6" component="h2" style={{ backgroundColor: 'rgba(255, 255, 255, 0.2)', }}>
        Filter by Date
      </Typography>
      <Select onChange={handleDateFilterChange} defaultValue="LAST_10_YEARS">
        <MenuItem value="LAST_7_DAYS">Last 7 Days</MenuItem>
        <MenuItem value="LAST_30_DAYS">Last 30 Days</MenuItem>
        <MenuItem value="LAST_180_DAYS">Last 90 Days</MenuItem>
        <MenuItem value="LAST_1_YEAR">Last 1 Year</MenuItem>
        <MenuItem value="LAST_5_YEARS">Last 5 Years</MenuItem>
        <MenuItem value="LAST_10_YEARS">Last 10 Years</MenuItem>
      </Select>
    </div>
  );
}
