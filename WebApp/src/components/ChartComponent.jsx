import { useEffect, useRef } from 'react';
import Chart from 'chart.js/auto';
import styled from 'styled-components';

const PieChartDiv = styled.div`
    margin-right: 10px;
`
const BarChartDiv = styled.div`
    margin-left: 10px;
    height: 500px;
    width: 500px;
`

const COLORS = ['#C9E4CA', '#87BBA2', '#55828B', '#3B6064', '#364958', '#6D9DC5', '#8BADC1', '#9DB7C4', '#B7C1C3', '#D2CCC1', '#E2D8BE', '#F2E4BB', '#FFEAB7', '#F9D29D', '#F5BA94', '#F1A18A', '#EC8981', '#E87077', '#E4586D', '#DF4063'];


export default function ChartComponent({ crimeTypes, crimeCount }) {

    const pieChartRef = useRef(null);
    const barChartRef = useRef(null);

    const pieChartInstanceRef = useRef(null);
    const barChartInstanceRef = useRef(null);

    useEffect(() => {
        const pieCtx = pieChartRef.current.getContext('2d');
        const barCtx = barChartRef.current.getContext('2d');

        // Destroy existing charts
        if (pieChartInstanceRef.current) pieChartInstanceRef.current.destroy();
        if (barChartInstanceRef.current) barChartInstanceRef.current.destroy();

        // Create new charts
        pieChartInstanceRef.current = new Chart(pieCtx, {
            type: 'pie',
            data: {
                labels: crimeTypes.map(type => type.label),
                datasets: [{
                    data: crimeTypes.map(type => type.value),
                    backgroundColor: COLORS,
                }]
            },
        });

        barChartInstanceRef.current = new Chart(barCtx, {
            type: 'bar',
            data: {
                labels: crimeCount.map(item => item.y_axis),
                datasets: [{
                    label: 'Number of Crimes',
                    data: crimeCount.map(item => item.crimes),
                    backgroundColor: '#3B6064',
                }]
            },
            options: {
                indexAxis: 'y',
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    }, [crimeTypes, crimeCount]);

    return (
        <div style={{ display: 'flex', flexDirection: 'row', overflowX: 'auto', width: '100%', marginTop: '50px', marginBottom: '50px' }}>
            <PieChartDiv>
                <canvas ref={pieChartRef} />
            </PieChartDiv>
            <BarChartDiv>
                <canvas ref={barChartRef} />
            </BarChartDiv>
        </div>
    );
}