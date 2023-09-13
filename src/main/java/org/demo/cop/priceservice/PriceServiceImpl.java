package org.demo.cop.priceservice;
import io.grpc.stub.StreamObserver;
import org.demo.cop.priceservice.proto.PriceServiceGrpc;
import org.demo.cop.priceservice.proto.Prices;

import java.util.UUID;

public class PriceServiceImpl extends PriceServiceGrpc.PriceServiceImplBase {
    private final String sourceId = UUID.randomUUID().toString();

    private final PriceGenerator priceGenerator = new PriceGenerator();

    public PriceServiceImpl() {

    }

    @Override
    public void getPrice(Prices.PriceRequest request, StreamObserver<Prices.PriceReply> responseObserver) {
        String ticker = request.getTicker();
        System.out.println("Serving request with ticker = " + ticker);
        Prices.PriceReply.Builder replyBuilder = Prices.PriceReply.newBuilder();
        replyBuilder.setSourceId(sourceId).setTicker(ticker).setPrice(priceGenerator.getPrice(ticker));
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}
