# Bug report for Quarkus Team

1. Install `grpcurl`
2. Run project
```
./mvnw quarkus:dev
```
3. Run
```
./start.sh
```
On random iterate you will receive an error:
```
jakarta.enterprise.context.ContextNotActiveException: RequestScoped context was not active when trying to obtain a bean instance for a client proxy of CLASS bean [class=io.quarkus.rest.client.reactive.runtime.HeaderContainer, id=w_QyeSkhamyoJ8l04Fy3rjzMfkM]
        - you can activate the request context for a specific method using the @ActivateRequestContext interceptor binding
        at io.quarkus.arc.impl.ClientProxies.notActive(ClientProxies.java:70)
        at io.quarkus.arc.impl.ClientProxies.getSingleContextDelegate(ClientProxies.java:30)
        at io.quarkus.rest.client.reactive.runtime.HeaderContainer_ClientProxy.arc$delegate(Unknown Source)
        at io.quarkus.rest.client.reactive.runtime.HeaderContainer_ClientProxy.getHeaders(Unknown Source)
        at io.quarkus.rest.client.reactive.runtime.MicroProfileRestClientRequestFilter.filter(MicroProfileRestClientRequestFilter.java:60)
        at org.jboss.resteasy.reactive.client.spi.ResteasyReactiveClientRequestFilter.filter(ResteasyReactiveClientRequestFilter.java:21)
        at org.jboss.resteasy.reactive.client.handlers.ClientRequestFilterRestHandler.handle(ClientRequestFilterRestHandler.java:25)
        at org.jboss.resteasy.reactive.client.handlers.ClientRequestFilterRestHandler.handle(ClientRequestFilterRestHandler.java:10)
        at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.invokeHandler(AbstractResteasyReactiveContext.java:231)
        at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:147)
        at org.jboss.resteasy.reactive.client.impl.AsyncInvokerImpl.performRequestInternal(AsyncInvokerImpl.java:285)
        at org.jboss.resteasy.reactive.client.impl.AsyncInvokerImpl.performRequestInternal(AsyncInvokerImpl.java:275)
        at org.jboss.resteasy.reactive.client.impl.AsyncInvokerImpl.method(AsyncInvokerImpl.java:215)
        at org.jboss.resteasy.reactive.client.impl.InvocationBuilderImpl.method(InvocationBuilderImpl.java:313)
        at am.plotnikov.bugreport1.client.GoogleClient$$QuarkusRestClientInterface.search(Unknown Source)
        at am.plotnikov.bugreport1.client.GoogleClient$$CDIWrapper.search(Unknown Source)
        at am.plotnikov.bugreport1.client.GoogleClient$$CDIWrapper_ClientProxy.search(Unknown Source)
        at am.plotnikov.bugreport1.service.KafkaService.processMessage(KafkaService.java:44)
        at am.plotnikov.bugreport1.service.KafkaService_ClientProxy.processMessage(Unknown Source)
        at am.plotnikov.bugreport1.service.KafkaService_SmallRyeMessagingInvoker_processMessage_4c7b22b897370ea933fd73d85f79da59638b74f4.invoke(Unknown Source)
        at io.smallrye.reactive.messaging.providers.AbstractMediator.lambda$invokeBlocking$15(AbstractMediator.java:191)
        at io.smallrye.context.impl.wrappers.SlowContextualSupplier.get(SlowContextualSupplier.java:21)
        at io.smallrye.mutiny.operators.uni.builders.UniCreateFromDeferredSupplier.subscribe(UniCreateFromDeferredSupplier.java:25)
        at io.smallrye.mutiny.operators.AbstractUni.subscribe(AbstractUni.java:36)
        at io.smallrye.mutiny.operators.uni.UniRunSubscribeOn.lambda$subscribe$0(UniRunSubscribeOn.java:27)
        at io.quarkus.virtual.threads.ContextPreservingExecutorService$ContextPreservingRunnable.run(ContextPreservingExecutorService.java:45)
        at java.base/java.util.concurrent.ThreadPerTaskExecutor$TaskRunner.run(ThreadPerTaskExecutor.java:314)
        at java.base/java.lang.VirtualThread.run(VirtualThread.java:309)
```