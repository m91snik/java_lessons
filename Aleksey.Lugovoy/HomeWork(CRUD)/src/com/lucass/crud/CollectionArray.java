package com.lucass.crud;

/**
 * Created by LugovoyAV on 29.07.2015.
 */
public class CollectionArray implements IOperations {
    static  final int InitialMaxCapacity = 10;


    int MaxCapacity;
    int size =0;

    @Override
    public void Add(double Value) {
        if (size == 0) {
            MaxCapacity = InitialMaxCapacity;
            data_array = new double[MaxCapacity];
        }
        if (size ==MaxCapacity) {
            MaxCapacity*=2;
            RenewArray(MaxCapacity);
        }
        data_array[size++]=Value;
    }

    @Override
    public void Insert(double Value, int Position) {
        if (Position>= size)
            throw new IllegalArgumentException("error argument");
        if (size == 0) {
            MaxCapacity = InitialMaxCapacity;
            data_array = new double[MaxCapacity];
        }
        if (size ==MaxCapacity) {
            MaxCapacity*=2;
            RenewArray(MaxCapacity);
        }
        for (int i = size; i > Position; i--) {
            data_array[i]=data_array[i-1];
        }
        data_array[Position]=Value;
        size++;
    }

    @Override
    public double GetAt(int Position) {

        if ((Position>0) && (Position< size))
            return data_array[Position];
        else
            throw new IllegalArgumentException("error argument");
    }

    @Override
    public void SetAt(double Value, int Position) {
        if ((Position>0) && (Position< size))
             data_array[Position] = Value;
        else
            throw new IllegalArgumentException("error argument");
    }

    @Override
    public void Delete(int Position) {
        if ((Position>0) && (Position< size))
        {
            double [] temp_array = new double[size -1];
            for (int i = 0; i < Position; i++) {
                temp_array[i] = data_array[i];
            }
            for (int i = Position+1; i < data_array.length; i++) {
                temp_array[i] = data_array[i];
            }
            data_array = temp_array;
        }
        else
            throw new IllegalArgumentException("error argument");
    }

    @Override
    public int GetSize() {
        return size;
    }

    private double [] data_array;

    private void RenewArray(int newSize){
        double [] temp_array = new double[newSize];
        for (int i = 0; i < data_array.length; i++) {
            temp_array[i] = data_array[i];
        }
        data_array = temp_array;
    }

}
