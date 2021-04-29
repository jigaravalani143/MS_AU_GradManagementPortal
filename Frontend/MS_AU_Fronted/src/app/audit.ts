export interface audit{
    id:number;
    date:Date;
    userName:string;
    userEmail:string;
    operation:string;
    oldValue:string;
    newValue:string;
}