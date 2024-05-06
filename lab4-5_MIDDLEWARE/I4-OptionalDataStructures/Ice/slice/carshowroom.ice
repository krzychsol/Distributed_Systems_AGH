module Carshowroom
{
    class CarOptional
    {
        string brand;
        string model;
        optional(1) int year;
    };

    class CarNoOptional
    {
        string brand;
        string model;
        int year;
    };

    interface CarshowroomService
    {
        bool addCarOptional(string brand, string model, optional(1) int year);
        bool addCarNoOptional(string brand, string model, int year);
        bool addCarStructOptional(CarOptional car);
        bool addCarStructNoOptional(CarNoOptional car);
    };
};

