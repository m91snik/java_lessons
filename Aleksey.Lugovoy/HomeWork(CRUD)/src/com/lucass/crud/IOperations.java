package com.lucass.crud;

/**
 * Created by LugovoyAV on 29.07.2015.
 */
public interface IOperations {
    void Add(double Value);
    void Insert(double Value, int Position);
    double GetAt(int Position);
    void SetAt(double Value, int Position);
    void Delete(int Position);
    int GetSize();
}
