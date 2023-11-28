import * as React from 'react';
import { PieChart } from '@mui/x-charts/PieChart';

export default function PieComponent() {

    return (
        <PieChart
            series={[
                {
                    data: [
                        { id: 0, value: 10, label: 'Murder' },
                        { id: 1, value: 15, label: 'Theft' },
                        { id: 2, value: 20, label: 'Hit and run' },
                    ],
                },
            ]}
            width={400}
            height={200}
        />
    );
}