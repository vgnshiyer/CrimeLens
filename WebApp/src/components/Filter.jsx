import { useState, useEffect } from "react";
import axios from "axios";

export default function Filter() {
    const [crimeTypes, setCrimeTypes] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:3000/crime_types')
            .then(res => {
                console.log(res.data);
                setCrimeTypes(res.data);
            })
            .catch(err => {
                console.log(err);
            })
    }, [])

    return (
        <div>Filter</div>
    )
}
