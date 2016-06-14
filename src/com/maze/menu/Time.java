/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.menu;

import com.maze.levels.Level;

/**
 *
 * @author thomas_laptop
 */
public class Time {
    
    private Integer hours, minutes, seconds;
    
    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    
    public String getTime() {
        String hour = this.hours.toString();
        String minute = this.minutes.toString();
        String second = this.seconds.toString();
        
        if (this.hours == 0) {
            hour = "00";
        } else if (this.hours < 10) {
            hour = "0" + this.hours;
        }
        
        if (this.minutes == 0) {
            minute = "00";
        } else if (this.minutes < 10) {
            minute = "0" + this.minutes;
        }
        
        if (this.seconds == 0) {
            second = "00";
        } else if (this.seconds < 10) {
            second = "0" + this.seconds;
        }
        
        String time = "Tijd: " + hour + ":" + minute + ":" + second + ",";
        
        return time;
    }
    
    public void addSecond() {
        if (this.seconds == 60) {
            this.seconds = 0;
            this.addMinute();
        } else {
            this.seconds++;
        }
    }
    
    public void takeSecond() {
        if (this.seconds == 0) {
            if (this.minutes > 0) {
                this.takeMinute();
                this.seconds = 59;
            }
        } else {
            this.seconds--;
        }
    }    
        
    private void addMinute() {
        if (this.minutes == 60) {
            this.addHour();
            this.minutes = 0;
        } else {
            this.minutes++;
        }
    }
    
    private void takeMinute() {
        if (this.minutes == 0) {
            if (this.hours > 0) {
                this.takeHour();
                this.minutes = 59;
            }
        } else {
            this.minutes--;
        }
    }    
    
    private void addHour() {
        this.hours++;
    }
    
    private void takeHour() {
        if (this.hours > 0) {
            this.hours--;
        }
    }
    
    public void resetTime() {
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
    }
    
     public void add20CheatSeconds() {

        if (this.seconds == 60) {
            this.seconds = 0;
            this.addMinute();
            this.seconds += 20;

        } else {

            this.seconds += 20;
        }
    }
}
