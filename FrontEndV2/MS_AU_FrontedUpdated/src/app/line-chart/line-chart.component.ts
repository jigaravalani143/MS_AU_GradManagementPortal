// import { OnInit } from '@angular/core';
// import { Component } from '@angular/core';
// import { HttpErrorResponse } from '@angular/common/http';
// import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
// import { Color, Label } from 'ng2-charts';
// import { GradService } from '../grad.service';
// import { Institute } from '../institute';
// import { Skill } from '../skill';

import { HttpErrorResponse } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { ChartDataSets, ChartType, ChartOptions, ChartColor } from 'chart.js';
import { Color, Label } from 'ng2-charts';
import { GradService } from '../grad.service';
import { Institute } from '../institute';
import { Skill } from '../skill';

@Component({
  selector: 'app-line-chart',
  templateUrl: './line-chart.component.html',
  styleUrls: ['./line-chart.component.css']
})
export class LineChartComponent {


  skills: Skill[] =[];
  instis:Institute[]=[];
  joinLocs:Location[]=[];
  joinYear:String[]=[];
  selectedParam: string;
  selectedCar: string;
  xParamVal:String[]=[];
  xParamOptions:String[]=['skill','institute','joining location'
 ,'join year'
]

  
  constructor(private gradService:GradService){}
  ngOnInit(): void {
    this.selectedParam="joining location";
   this.getLabels("joining location");

  }
 

  // Array of different segments in chart
  lineChartData: ChartDataSets[] = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Product A' }
  ];

  //Labels shown on the x-axis
  lineChartLabels: Label[] = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];

  // Define chart options
  lineChartOptions: ChartOptions = {
    responsive: true
  };

  lineChartColors: Color[] = [
    {
      borderColor: 'black',
      backgroundColor: 'rgba(255,255,0,0.28)',
    },
  ];

  // Set true to show legends
  lineChartLegend = true;

  // Define type of chart
  lineChartType: ChartType ='line';

  lineChartPlugins = [];

  chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
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
    this.gradService.getLabels(label).subscribe(
      (respone)=>{
        console.log(respone)
        this.lineChartLabels=respone.labels;
        this.lineChartData[0] = respone.chartData
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
  }
}

