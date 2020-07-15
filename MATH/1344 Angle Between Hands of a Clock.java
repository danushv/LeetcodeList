a clock will be given we have to find the angle between them 

class Solution {
    public double angleClock(int hour, int minutes) {
        float h = (hour%12 +(float)minutes/60)*30; // angle between two hour is 30 so it is multiplied by 30 and  hours %12 is done because 12 is considered the starting point also we are converting to the minutes so that is the reason we are adding minutes
        float m= minutes*6;// angle between two minute angle is 6 so we are multiplying with 30 ass above we did in hour hand
        float angle= Math.abs(h-m); // the angle is the diff between hour and minutes
        if(angle>180)// if it is more than 180 then subtract is it means we have to return the small angle
        {
            angle=360-angle;
        }
        return angle;
    }
}
