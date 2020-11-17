# Under the hood of Java execution

- Java run as a process, with each instance of JVM.
- Each application has its own memory space, called HEAP. HEAP is not shared between JVM processes.
- Thread is a unit of execution within a process.
- Each JVM process has at least one thread where the program, known as main thread.
- Each JVM also have multiple system thread like memory management, IO etc.
- They can many optionally multiple user defined thread.
- Threads that are part of same process shares the memory and files of the process.
- This problem should be carefully taken care.
- In addition to memory (the heap) each thread has thread stack (memory that only thread can access.).
- Execution scheduling of thread are not possible in java. 

## Advantages of thread

- For long-running processes we can use  thread, when we don't want to block the main thread.
    - For example query database.
- Async functionality require thread as java processes depends on external system/networks for processing.

## Concurrency

This does not mean that multiple jobs are running simultaneously. Concurrency means that we don't need to wait for current task to complete before starting another one. 

## Thread class

- Thread class help's developer to create and manage thread.
- Thread class implements Runnable interface. *Runnable interface have only one abstract method - abstract void run*

## Critical section

refers to a code, which reference to a shared resource.

## Thread safe

when a class or method are thread save means developer have synchronized all the critical sections

In javadoc you may find that few classes are not thread safe. For eg: ArrayList.

## Synchronized

- avoid race condition
- provide a lock with a thread, until a lock is released
- any method can be sync, both static, non static
- constructor can't be synced
- we can sync a blk of code as well
    - but in that case don't use local variable apart from string
- Code that need(required) to be sync, apply there. else it will impact performance of the app.

### Problem with synchronization

- Threads wait until the other thread releases the lock. May led to deadlock scenario.
- Synchronization block cant be extended between methods.
- Less testable code.

We can use util.concurrent package to overcome some the problems.

## lock

- these are alternative of synchronized.
- lock objects are implemented on util.concurrent package.

## Suspension point

Point at which OS may suspend a thread.

Eg:
thread may suspended in between System.out.println. Between processing and printing for example.

### Atomic

Atomic actions cant be suspended.

There are certain operation in java known as `atomic`, meas thread CANT be suspended in between.

Eg: 

- writing ref variable.
- writing to primitive type accept long or double.
- read write of volatile variables 

## Race condition

Use locks or synchronize-block or function to resolve race condition.
 
### Deadlock and livelock

Another type of race condition.

Deadlock - threads may blocked for each other. In those scenarios you may use wait and notify, `notifyall`.
Livelock - threads will not be blocked but will WAIT and not be able to do the actual thing required. When both the thread are running  in a loop and waiting for to other to complete.

### Starvation

Another type of race condition.

- this is caused because of priority.
- priority is just a suggestion to OS, however the thread are scheduled by OS which may not always respect priority.  

### Slipped condition (thread interference)

Another type of race condition.

Multiple thread get permission to do the task, but one completes before other, and the other fails.

Basically one thread is acting on the shared resource based on obsolete status.

## Lifecycle

refer the image

## Thread pools

- Thread are managed threads.
- We still implement the runnable interface or extend thread class, but the lifecycle of the thread is managed by JVM.

## Return a value from thread

- callable object

## Difference b/w runnable and callable

- `runnable` and `callable` are same which can be executed by other threads.
- `runnable` interface do not return any value or throws any exception. However, `callable` do.
- Executor class are used to convert `runnable` to `callable`.
- And when `callable` is passed to executor, `future` object is returned.