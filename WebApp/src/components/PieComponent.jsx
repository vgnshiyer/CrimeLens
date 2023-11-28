import { PieChart } from '@mui/x-charts/PieChart';
import { BarChart } from '@mui/x-charts/BarChart';

export default function PieComponent() {

    return (
        <div style={{ display: 'flex', flexDirection: 'row', overflowX: 'auto', width: '100%' }}>
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
            <BarChart
                xAxis={[{ scaleType: 'band', data: ['group A', 'group B', 'group C'] }]}
                series={[{ data: [4, 3, 5] }, { data: [1, 6, 3] }, { data: [2, 5, 6] }]}
                width={500}
                height={300}
            />
        </div>
    );
}