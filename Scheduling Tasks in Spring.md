#java #spring #scheduling 
# Enable Scheduling at Application level
See `@SpringBootApplication`, `@EnableScheduling`
```java
@SpringBootApplication
@EnableScheduling
public class SchedulingTasksApplication {
```
# Annotate Component with Scheduled
Annotate the method in a Component that you would like to schedule. 
See `@Component`, `@Scheduled`
```java
@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(initialDelay = 1000, fixedRate = 50, timeUnit = TimeUnit.SECONDS, )
	public void doAtFixedRate() {
		log.info("The time is now {}", dateFormat.format(new Date()));
	}
	
	@Scheduled(initialDelay = 1000, fixedDelay = 5000) 
	public void doAtFixedDelay() { 
		log.info("The time is now {}", dateFormat.format(new Date()));
	}

	@Scheduled(cron="*/5 * * * * MON-FRI") 
	public void doAtCron() { 
		log.info("The time is now {}", dateFormat.format(new Date()));
	}
```
# fixedRate vs fixedDelay
- `fixedRate` will trigger executions at a rate irrespective of the completion of the previous invocation
- `fixedDelay` will trigger execution once the configured time has elapsed after the previous invocation

# Best Practices
- Guard the method execution with a configuration to control at runtime

# Reference
- [spring.io scheduling tasks](https://spring.io/guides/gs/scheduling-tasks)
- [Options for @Scheduled annotation](https://docs.spring.io/spring-framework/reference/integration/scheduling.html#scheduling-annotation-support-scheduled)
