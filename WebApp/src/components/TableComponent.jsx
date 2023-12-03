import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
} from "@mui/material";


export default function TableComponent({ crimes }) {

  const tableStyle = {
    borderRadius: '15px',
    marginTop: '10px',
    marginRight: '15px',
    marginBottom: '10px',
    minWidth: 650,
    backgroundColor: '#6e6e6e34',
    border: '1px solid #ffffffa6',
    color: '#fff', // Add this line
  };

  const headerStyle = {
    backgroundColor: '#c94a4a31',
    color: 'white',
    borderRight: '1px solid #ffffffa6',
    borderLeft: '1px solid #ffffffa6',
    fontWeight: 'bold',
    textTransform: 'uppercase',
  };

  const cellStyle = {
    borderRight: '1px solid #ffffffa6',
    borderLeft: '1px solid #ffffffa6',
    color: '#fff',
  };
  /*
    [
        {
            id: 1,
            classification: 'Theft',
            description: 'Theft of property',
            date: '2021-10-10',
            location: '123 Street, City, State, Zip'
        },
        {

        }
    ]
    */
  const columnNames = crimes[0] ? Object.keys(crimes[0]) : [];
  console.log(columnNames);

  return (
    <TableContainer component={Paper} style={tableStyle}>
      <Table>
        <TableHead>
          <TableRow>
            {columnNames.map((columnName, index) => (
              <TableCell key={index} style={headerStyle}>{columnName}</TableCell>
            ))}
          </TableRow>
        </TableHead>
        <TableBody>
          {crimes.map((row, index) => (
            <TableRow key={index}>
              {columnNames.map((columnName, index) => (
                <TableCell key={index} style={cellStyle}>
                  {columnName === 'location' ? row[columnName].street :
                    (row[columnName] !== undefined && row[columnName] !== null ? row[columnName] : '')
                  }
                </TableCell>
              ))}
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
