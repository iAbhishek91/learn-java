# Concurrent package

This package was introduced in java 1.5.

helps in:

- writing codes that involves multiple threads.
- handle concurrency.

refer: challenges.producerconsumer.usingconcurrent

## Fair lock

Only thing fair lock grantees, "first come, first served". All lock object do not have fair lock implementation.

Reentrant Object do have. Refer: FairLock.java

> NOTE: performance is impacted when there are lots of thread.