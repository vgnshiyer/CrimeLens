import { List, ListItem, ListItemText, Typography } from "@mui/material";
import styled, { keyframes } from 'styled-components';

function CrimeFeed({ crimes, onCrimeSelect }) {

  const blink = keyframes`
    0% {opacity: 1;}
    50% {opacity: 0;}
    100% {opacity: 1;}
  `;

  const BlinkingDot = styled.div`
    width: 10px;
    height: 10px;
    background-color: red;
    border-radius: 50%;
    animation: ${blink} 1s linear infinite;
    margin-left: 10px;
    margin-top: 10px;
  `;

  return (
    <div style={{ backgroundColor: '#20070B', borderRadius: '6px', padding: '10px', marginTop: '55px', marginLeft: '15px' }}>
      <div style={{ display: 'flex', justifyContent: 'center', marginTop: '0', padding: '0' }}>
        <Typography variant="h6" component="h2" style={{ backgroundColor: '#20070B', }}>
          Live Feed
        </Typography>
        <BlinkingDot />
      </div>
      {crimes && crimes.length > 0 && (
        <List>
          {crimes.map((crime, index) => (
            <ListItem button key={crime._id} onClick={() => handleListItemClick(crime)} style={{ color: '#fdf0d5' }}>
              <ListItemText
                primary={`${crime.classification} ${crime.description === null ? '' : - crime.description}`}
                secondary={`${crime.crimeDate}, ${crime.city}, ${crime.state}`}
                secondaryTypographyProps={{style: {color: 'lightcoral'}}}
              />
            </ListItem>
          ))}
        </List>
      )}
    </div>
  );

  function handleListItemClick(crime) {
    onCrimeSelect(crime);
  }
}

export default CrimeFeed;
