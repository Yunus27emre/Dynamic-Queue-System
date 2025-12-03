# Dynamic Queue System (Java)

This project implements a fully dynamic, array-based queue structure in Java.  
The application reads commands from an input file (`Kuyruk.txt`), validates data types,  
resizes the queue automatically, and processes operations such as enqueue, dequeue, and peek.

## Features
- Dynamic queue resizing (expand & shrink)
- Circular array implementation
- Full type checking (`int`, `double`, `char`, `String`)
- Defensive error handling (invalid types, invalid capacity, malformed input)
- File-based command processing
- Clean and modular structure (`Queue_make`, `FileRead`, `error_look`)

## Example Input (Kuyruk.txt)
2
int double char
ekle 45
ekle 'A'
ekle 3.14
çıkar
peek


## Example Output
45 kuyruğa eklendi.
Kapasite:2 Eleman Sayısı:1 Başı 45 Sonu
'A' kuyruğa eklendi.
Kapasite:2 Eleman Sayısı:2 Başı 45, 'A' Sonu
3.14 kuyruğa eklendi.
Kapasite:4 Eleman Sayısı:3 Başı 45, 'A', 3.14 Sonu
45 kuyruktan çıktı.
...

Author

Yunus Emre Taşkesen
Computer Engineering – 2025

