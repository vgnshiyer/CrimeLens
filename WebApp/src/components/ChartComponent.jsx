import { PieChart } from '@mui/x-charts/PieChart';
import { BarChart } from '@mui/x-charts/BarChart';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { environment } from '../../environment';

const api_url = environment.crimelensapi.url_dev;

const chartSetting = {
    yAxis: [
        {
            label: 'Number of Crimes',
        },
    ],
    width: 500,
    height: 400,
};

const dataset = [
    { year: '2015', crimes: 100 },
    { year: '2016', crimes: 120 },
    { year: '2017', crimes: 150 },
    { year: '2018', crimes: 180 },
    { year: '2019', crimes: 200 },
    { year: '2020', crimes: 220 },
    { year: '2021', crimes: 250 },
];

const valueFormatter = (value) => `${value}`;

export default function ChartComponent({crimeTypes, crimeCountByYear}) {

    return (
        <div style={{ display: 'flex', flexDirection: 'row', overflowX: 'auto', width: '100%' }}>
            <PieChart
                series={[
                    {
                        data: crimeTypes,
                    },
                ]}
                width={400}
                height={200}
            />
            {crimeCountByYear && crimeCountByYear.length > 0 && (
                <BarChart
                    dataset={crimeCountByYear}
                    xAxis={[{ scaleType: 'band', dataKey: 'year' }]}
                    series={[{ dataKey: 'crimes', label: 'Number of Crimes', valueFormatter }]}
                    layout='vertical'
                    {...chartSetting}
                />
            )}
        </div>
    );
}