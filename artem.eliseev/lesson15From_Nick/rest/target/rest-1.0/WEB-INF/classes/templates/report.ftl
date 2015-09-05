<#list expenses as expense>
    ${expense.amount} ${expense.currency} ${expense.description} was spent at ${expense.creationTime}. ${expense.comment}
</#list>