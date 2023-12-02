import { useState, useEffect } from "react";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
} from "@mui/material";


export default function TableComponent({crimes}) {
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
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            {columnNames.map((columnName, index) => (
              <TableCell key={index}>{columnName}</TableCell>
            ))}
          </TableRow>
        </TableHead>
        <TableBody>
          {crimes.map((row, index) => (
            <TableRow key={index}>
              {columnNames.map((columnName, index) => (
                <TableCell key={index}>{row[columnName]}</TableCell>
              ))}
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
