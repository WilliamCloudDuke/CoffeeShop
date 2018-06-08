package edu.mum.coffee.rest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController
public class ShoppingCartRestService {

	@Autowired
	private ProductService pService;

	@RequestMapping(value = "/carts", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addICoffeeToShoppingCarts(@RequestBody int productId, HttpSession session) {
		Object orderO = session.getAttribute("orderCart");
		if (null == orderO) {
			orderO = new Order();
			session.setAttribute("orderCart", orderO);
		}
		Order order = (Order) orderO;
		Optional<Orderline> oLine = order.getOrderLines().stream().filter(o -> o.getProduct().getId() == productId)
				.findFirst();

		if (oLine.isPresent()) {
			// Orderline is already created and need to add 1 element
			Orderline orderLine = oLine.get();
			orderLine.setQuantity(orderLine.getQuantity() + 1);
		} else {
			// Orderline has not been created so create a new one
			Product p = pService.findById(productId);
			Orderline orderLine = new Orderline();
			orderLine.setProduct(p);
			orderLine.setQuantity(1);
			order.addOrderLine(orderLine);
		}
	}

	@DeleteMapping("/shopping-cart/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteICoffeeInShoppingCart(@PathVariable("productId") int productId, HttpSession session) {
		Object orderO = session.getAttribute("orderCart");
		if (null == orderO) {
			orderO = new Order();
			session.setAttribute("orderCart", orderO);
		}
		Order order = (Order) orderO;
		Optional<Orderline> oLine = order.getOrderLines().stream().filter(o -> o.getProduct().getId() == productId)
				.findFirst();
		if (oLine.isPresent()) {
			order.removeOrderLine(oLine.get());
		}
	}

	@PostMapping("/cart")
	@ResponseStatus(HttpStatus.OK)
	public void addICoffeeToShoppingCart(@RequestBody int productId, HttpSession session) {
		Object orderO = session.getAttribute("orderCart");
		if (null == orderO) {
			orderO = new Order();
			session.setAttribute("orderCart", orderO);
		}
		Order order = (Order) orderO;
		Optional<Orderline> oLine = order.getOrderLines().stream().filter(o -> o.getProduct().getId() == productId)
				.findFirst();

		if (oLine.isPresent()) {
			// Orderline is already created and need to add 1 element
			Orderline orderLine = oLine.get();
			orderLine.setQuantity(orderLine.getQuantity() + 1);
		} else {
			// Orderline has not been created so create a new one
			Product p = pService.findById(productId);
			Orderline orderLine = new Orderline();
			orderLine.setProduct(p);
			orderLine.setQuantity(1);
			order.addOrderLine(orderLine);
		}
	}

	@GetMapping("/product-list")
	public List<Product> getProductList() {
		return pService.findAll();
	}

}
