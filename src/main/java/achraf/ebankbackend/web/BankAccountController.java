package achraf.ebankbackend.web;

import achraf.ebankbackend.dtos.AccountHistoryDTO;
import achraf.ebankbackend.dtos.BankAccountDTO;
import achraf.ebankbackend.dtos.OperationDTO;
import achraf.ebankbackend.exceptions.BankAccountNotFoundException;
import achraf.ebankbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountController {
    private BankAccountService bankAccountService;

    @GetMapping("/accounts/{accountID}")
    public BankAccountDTO getBankAccount(@PathVariable String accountID) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountID);
    }

    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts(){
        return bankAccountService.bankAccountList();
    }

    @GetMapping("/accounts/{accountId}/history")
    public List<OperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        return bankAccountService.getAccountHistory(accountId, page, size);
    }
}
