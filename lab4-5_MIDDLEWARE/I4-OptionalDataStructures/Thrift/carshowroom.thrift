namespace java genjava
namespace py genpython

struct CarOptional {
  1: string brand,
  2: string model,
  3: optional i32 year,
}

struct CarNoOptional {
  1: string brand,
  2: string model,
  3: i32 year,
}
 
service CarshowroomService {
   bool addCarOptional(1:string brand, 2: string model, 3: optional i32 year);
   bool addCarNoOptional(1:string brand, 2: string model, 3: i32 year);
   bool addCarStructOptional(1: CarOptional car);
   bool addCarStructNoOptional(1: CarNoOptional car);
}
