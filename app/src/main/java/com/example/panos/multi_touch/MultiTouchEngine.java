package com.example.panos.multi_touch;

import android.text.method.Touch;

import java.util.HashMap;
import java.util.Map;

public class MultiTouchEngine {
    protected Map<Integer,TouchPointer> pointers;

    public MultiTouchEngine(){
        pointers = new HashMap<>();
    }

    public void add(int id, float xx, float yy){
        TouchPointer pointer = new TouchPointer(id,xx,yy);
        pointers.put(id,pointer);
    }

    public void update(int id, float xx, float yy){
        TouchPointer pointer = pointers.get(id);
        if(pointer!=null){
            pointer.xx = xx;
            pointer.yy = yy;
        }
    }

    public void remove(int id){
        pointers.remove(id);
    }

    public void pickOneWinner(){
        int size = pointers.values().size();
        int choice = (int) Math.floor(Math.random()*size);

        int n = 0;

        for(TouchPointer pointer : pointers.values()){
            if(n!=choice){
                pointer.isDisabled = true;
            }else{
                pointer.isDisabled = false;
            }
            n++;
        }
    }

}
