package internship.dlithe.twentyone.DLithe2021Internship;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import internship.dlithe.twentyone.DLithe2021Internship.controllers.RepoAccount;
import internship.dlithe.twentyone.DLithe2021Internship.controllers.RepoBeneficiary;
import internship.dlithe.twentyone.DLithe2021Internship.controllers.ServiceAccount;
import internship.dlithe.twentyone.DLithe2021Internship.controllers.ServiceBeneficiary;
import internship.dlithe.twentyone.DLithe2021Internship.model.Account;
import internship.dlithe.twentyone.DLithe2021Internship.model.Beneficiary;


@SpringBootTest
@RunWith(SpringRunner.class)
class DLithe2021InternshipApplicationTests 
{
	@MockBean
	RepoAccount repo;
	
	@MockBean
	RepoBeneficiary benrepo;
	
	@Autowired
	ServiceAccount service;
	
	@Autowired
	ServiceBeneficiary servben;
	
	/*
	 * @Test void contextLoads() { }
	 */

	@Test
	public void testInsertion()
	{
		Account acc=new Account(987656789L, "Mohamed", "ABCD111", "SAlem", "razzaksr@gmail.com", "Savings", "abcabc", 9876568987L, 1200.8);
		Account acc2=new Account(987646732323L, "Sabari", "JSHC34E4", "SAlem,India", "sabariragu@gmail.com", "Current", "skjdcbksd", 82733444L, 120100.8);
		when(repo.save(acc)).thenReturn(acc);
		assertEquals(acc.getAccHolder(),service.insert(acc));
	}
	
	@Test
	public void testLogin()
	{
		Optional<Account> acc=Optional.of(new Account(987656789L, "Mohamed", "ABCD111", "SAlem", "razzaksr@gmail.com", "Savings", "abcabc", 9876568987L, 1200.8));
		when(repo.findById(987656789L)).thenReturn(acc);
		assertTrue(service.fetchOne(987656789L).getBalance().equals(1200.8));
	}
	
	@Test
	public void testAddBen()
	{
		Beneficiary ben=new Beneficiary(9876545678L, "Aravind", "ABCDE00001", "Indian Bank");
		Beneficiary ben1=new Beneficiary(12323121212L, "Aravind", "ABCDE00001", "Indian Bank");
		when(benrepo.save(ben)).thenReturn(ben);
		assertTrue(servben.add(ben).equals(ben));
	}
	
	@Test
	public void testBeneficiaries()
	{
		when(benrepo.findAll()).thenReturn(Stream.of(new Beneficiary(98765672343L,null,"abcd1234e","Canara Bank"),
				new Beneficiary(8767232223L,"Sabarinathan","12323abcd","Indian Bank"),
				new Beneficiary(123234323423L,"Richard","abcd1234e","Canara Bank")).collect(Collectors.toList()));
		assertEquals(3, servben.getAll().size());
		assertNotNull(servben.getAll().get(2).getName());
		assertNull(servben.getAll().get(0).getName());
	}
	
	@Test
	public void testUpdate()
	{
		Beneficiary ben=new Beneficiary(9876545678L, "Aravind", "ABCDE00001", "Indian Bank");
		Beneficiary ben1=new Beneficiary(12323121212L, "Aravind", "ABCDE00001", "Indian Bank");
		when(benrepo.save(ben)).thenReturn(ben);
		assertNotEquals("Andhra bank", servben.add(ben).getBank());
	}
	
	@Test
	public void testDelete()
	{
		Beneficiary ben1=new Beneficiary(12323121212L, "Aravind", "ABCDE00001", "Indian Bank");
		servben.remove(ben1);
		verify(benrepo,times(1)).delete(ben1);
	}
}
