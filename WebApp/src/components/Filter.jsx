import React from "react";
import { RadioGroup, FormControlLabel, Radio } from "@mui/material";

export default function Filter({ crimeTypes, setSelectedCrimeType }) {
    const handleChange = (event) => {
        setSelectedCrimeType(event.target.value === 'ALL' ? '' : event.target.value);
    };

    return (
        <div>
            <label>Crime Type: </label>
            <RadioGroup onChange={handleChange} defaultValue="ALL">
                <FormControlLabel value="ALL" control={<Radio />} label="ALL" />
                {crimeTypes.map((type, index) => (
                    <FormControlLabel key={index} value={type.label} control={<Radio />} label={type.label} />
                ))}
            </RadioGroup>
        </div>
    );
}