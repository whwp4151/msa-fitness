package com.project.payment.service;

import com.project.payment.domain.Order;
import com.project.payment.domain.OrderStatus;
import com.project.payment.domain.Payment;
import com.project.payment.dto.OrderDto;
import com.project.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    public final PaymentRepository paymentRepository;

    public final OrderService orderService;

    public Payment savePayment(OrderDto orderDto, String userId){
        Order updateOrder = orderService.updateOrder(orderDto.getId(), OrderStatus.FINISHED);
        OrderDto dto = OrderDto.builder()
                .id(orderDto.getId())
                .userId(userId)
                .lessonId(updateOrder.getLessonId())
                .lessonName(updateOrder.getLessonName())
                .lessonPrice(updateOrder.getLessonPrice())
                .paymentType(updateOrder.getPaymentType())
                .build();


        return paymentRepository.save(new Payment(dto));
    }

    public Order cancelPayment(OrderDto orderDto, String userId){
        return orderService.updateOrder(orderDto.getId(), OrderStatus.CANCEL);
    }
}
