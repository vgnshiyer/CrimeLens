import { List, ListItem, ListItemText, Typography } from "@mui/material";

function CrimeFeed({ crimes, onCrimeSelect }) {

  // TODO: Add colors to the list items
  const colors = ["red", "blue", "green", "yellow", "purple"];

  return (
    <div>
      <Typography variant="h6" component="h2" style={{ backgroundColor: 'rgba(255, 255, 255, 0.2)', }}>
        Live Feed
      </Typography>
      {crimes && crimes.length > 0 && (
        <List>
          {crimes.map((crime, index) => (
            <ListItem button key={crime._id} onClick={() => handleListItemClick(crime)} style={{ color: colors[index % colors.length] }}>
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
