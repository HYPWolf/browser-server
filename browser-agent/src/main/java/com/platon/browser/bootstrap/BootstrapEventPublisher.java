package com.platon.browser.bootstrap;

import com.alaya.protocol.core.methods.response.PlatonBlock;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventTranslatorThreeArg;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import com.platon.browser.publisher.AbstractPublisher;
import com.platon.browser.client.ReceiptResult;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

/**
 * 自检事件生产者
 */
@Slf4j
@Component
public class BootstrapEventPublisher extends AbstractPublisher<BootstrapEvent> {
    private static final EventTranslatorThreeArg<BootstrapEvent,CompletableFuture<PlatonBlock>,CompletableFuture<ReceiptResult>, Callback>
    TRANSLATOR = (event, sequence, blockCF,receiptCF,callback)->{
        event.setBlockCF(blockCF);
        event.setReceiptCF(receiptCF);
        event.setCallback(callback);
    };
    @Value("${disruptor.queue.block.buffer-size}")
    private int ringBufferSize;
    @Override
    public int getRingBufferSize() {
        return ringBufferSize;
    }

    private EventFactory<BootstrapEvent> eventFactory = BootstrapEvent::new;
    @Resource
    private BootstrapEventHandler handler;

    @Getter
    private Disruptor<BootstrapEvent> disruptor;

    @PostConstruct
    public void init(){
        disruptor = new Disruptor<>(eventFactory, ringBufferSize, DaemonThreadFactory.INSTANCE);
        disruptor.handleEventsWith(handler);
        disruptor.start();
        ringBuffer = disruptor.getRingBuffer();
        register(BootstrapEventPublisher.class.getSimpleName(),this);
    }

    public void publish(CompletableFuture<PlatonBlock> blockCF, CompletableFuture<ReceiptResult> receiptCF, Callback callback){
        ringBuffer.publishEvent(TRANSLATOR, blockCF,receiptCF,callback);
    }

    public void shutdown() {
        disruptor.shutdown();
        unregister(BootstrapEventPublisher.class.getSimpleName());
    }
}
