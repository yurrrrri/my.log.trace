package io.myLogTrace.command.category;

import io.myLogTrace.command.vo.OrderInfo;
import lombok.Getter;

import java.util.List;

@Getter
public class ModifyCategoryOrder {
  //
  private List<OrderInfo> orderInfos;
}
