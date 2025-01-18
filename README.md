# Scheduler Mod
A FabricMC library mod, that allows you to schedule tasks.

## Example Usage

### Getting started

Add the jitpack maven repository:
```groovy
maven {
    url "https://jitpack.io"

    metadataSources {
        artifact() // Look directly for artifact
    }
}
```

Add the dependency:
```groovy
include(modImplementation("com.github.DrTheodor:mc-scheduler:v1.0.1"))
```

To schedule a client task use `ClientScheduler`. `ClientScheduler` clears the tasks if they are either marked as finished (cancelled).

To schedule a server task use `Scheduler`. `Scheduler` clears the tasks if they are either marked as finished (cancelled) OR the server is stopping.


To get a scheduler's instance, use its `#get` method.

All schedulers inherit `BaseScheduler` which has methods as follows:
- `#runTaskLater` - runs a task after a certain period of time.
- `#runAsyncTaskLater` - runs an async task after a certain period of time.
- `#runTaskTimer` - runs a repeating task after a certain period of time. Returning `true` finishes the task.
- `#runAsyncTaskTimer` - runs an _async_ repeating task every a certain period of time. Returning `true` finishes the task.
