import { List, ListItem, ListItemText, Typography } from "@mui/material";

function CrimeFeed({ crimes, onCrimeSelect }) {
  return (
    <div>
      <Typography variant="h5" component="h2">
        Live Feed
      </Typography>
      {crimes && crimes.length > 0 && (
        <List>
          {crimes.map((crime) => (
            <ListItem button key={crime._id} onClick={() => handleListItemClick(crime)}>
              <ListItemText
                primary={`${crime.classification} - ${crime.description}`}
                secondary={`${crime.crimeDate}, ${crime.location.street}`}
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
