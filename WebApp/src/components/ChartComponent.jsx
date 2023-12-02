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

const valueFormatter = (value) => `${value}`;

export default function ChartComponent({ crimeTypes, crimeCountByYear }) {

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