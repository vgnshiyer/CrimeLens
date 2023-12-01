import { List, ListItem, ListItemText, Typography } from "@mui/material";

function CrimeFeed({ crimes }) {
  return (
    <div>
      <Typography variant="h5" component="h2">
        Live Feed
      </Typography>
      {crimes && crimes.length > 0 && (
        <List>
          {crimes.map((crime) => (
            <ListItem key={crime._id}>
              <ListItemText
                primary={`${crime.classification} - ${crime.description}`}
                secondary={`${crime.crimeDate}, ${crime.street}`}
              />
            </ListItem>
          ))}
        </List>
      )}
    </div>
  );
}

export default CrimeFeed;
