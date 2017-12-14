package org.wzz.test.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.core.style.ToStringCreator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.wangzz.core.utils.json.MyDateSerializer;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message="不能为空")
	@Size(min = 1, max = 25, message="长度在{min}到{max}之间")
	private String name;

	@NotNull(message="不能为空")
	@NumberFormat(style = Style.CURRENCY)
	private BigDecimal balance = new BigDecimal("1000");

	@NotNull(message="不能为空")
	@NumberFormat(style = Style.PERCENT)
	private BigDecimal equityAllocation = new BigDecimal(".60");

	@DateTimeFormat(style = "S-")
	@Future
	private Date renewalDate = new Date(new Date().getTime() + 31536000000L);

	@JsonIgnore 
	public Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getEquityAllocation() {
		return equityAllocation;
	}

	public void setEquityAllocation(BigDecimal equityAllocation) {
		this.equityAllocation = equityAllocation;
	}

	@JsonSerialize(using = MyDateSerializer.class)
	public Date getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}

	public Long assignId() {
		this.id = idSequence.incrementAndGet();
		return id;
	}

	private static final AtomicLong idSequence = new AtomicLong();

	public String toString() {
		return new ToStringCreator(this).append("id", id).append("name", name)
				.append("balance", balance).append("equityAllocation",
						equityAllocation).append("renewalDate", renewalDate)
				.toString();
	}
	
	public static void main(String[] args) {
		Account account = new Account();
		account.setId(12l);
		account.setBalance(new BigDecimal(123));
		account.setName("wzz");
		account.setRenewalDate(new Date());
		
		Account account2 = new Account();
		account2.setId(12l);
		account2.setBalance(new BigDecimal(456));
		account2.setName("wxh");
		account2.setRenewalDate(new Date());
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account);accounts.add(account2);
		
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			String a = mapper.writeValueAsString(accounts);
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}