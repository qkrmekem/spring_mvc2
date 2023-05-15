package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총합이 10000이상이 되도록 입력해주세요")
public class Item {

//    @NotNull(groups = UpdateCheck.class) // 수정 요구사항 추가
    // HTTP요청은 악의적으로 변경해서 요청(post맨 이용 등)할 수 있으므로 서버에서도 검증해야함
    private Long id;

//    @NotBlank(groups = {SaveCheck.class, UpdateCheck.class}) //(message = "공백X")
    private String itemName;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    @Range(min = 1000, max = 1000000)
    private Integer price;

//    @NotNull
//    @Max(value = 9999, groups = {SaveCheck.class}) // 수정 요구사항 추가
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
