package com.codeup.blog.services;

import org.springframework.stereotype.Service;

@Service
public class NumberUrlService {

    public double perimeter(double n){
        return n*4;
    }
    public double area(double n){
        return n*n;
    }
    public double volume(double n){
        return n*n*n;
    }
    public double circleArea(double r){
        return r*r*Math.PI;
    }
    public double circumference(double r){
        return 2*r* Math.PI;
    }
    public double isPrime(double n){
        for(int i = 2; i < n; i++){
            if(n % i ==0){return 0;}
        }
        return 1;
    }
}
