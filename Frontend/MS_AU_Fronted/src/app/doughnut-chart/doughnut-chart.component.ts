// doughnut-chart-component.ts
import { Component, OnInit } from '@angular/core';
import { Label, MultiDataSet, Color } from 'ng2-charts';
import { ChartType, ChartOptions } from 'chart.js';
import { HttpErrorResponse } from '@angular/common/http';
import { GradService } from '../grad.service';

@Component({
  selector: 'app-doughnut-chart',
  templateUrl: './doughnut-chart.component.html',
  styleUrls: ['./doughnut-chart.component.css']
})
export class DoughnutChartComponent {

  selectedParam: string;
  xParamOptions:String[]=['skill','institute','joining location','join year']

constructor(private gradService:GradService){}
doughnutChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      position: 'top',
    },
    tooltips: {
      enabled: true,
      mode: 'single',
      callbacks: {
        label: function (tooltipItems, data) {
          console.log(JSON.stringify(data.datasets[0].data));
          
          return data.datasets[0].data[tooltipItems.index] + ' %';
        }
      }
    },
  };

  doughnutChartLabels: Label[] = [];

  doughnutChartData: number[] =[];

  doughnutChartType: ChartType = 'doughnut';

  doughnutChartLegend = true;

  doughnutChartPlugins = [];

  doughnutChartColors = [
    {
      backgroundColor: ['rgba(255,0,0,0.3)', 'rgba(0,255,0,0.3)', 'rgba(0,0,255,0.3)','rgba(255,255,0,0.3)','rgb(255,165,0,0.5)'],
    },
  ];
  ngOnInit(): void {
    this.selectedParam="join year";
    this.getLabels("join year");
  }
  onShow(){
    if(this.selectedParam==="skill")
    {
      this.getLabels("skill");
    }else if(this.selectedParam==="institute"){
      this.getLabels("institute");
    }else if(this.selectedParam==="join year"){
      this.getLabels("join year");
          }else{
      this.getLabels("joining location");
    }
  }
  public getLabels(label:String):void{
    this.gradService.getLabelsPie(label).subscribe(
      (respone)=>{
        console.log(respone)
        this.doughnutChartLabels=respone.labels;
        this.doughnutChartData = respone.chartData.data;
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
  }





}




  
