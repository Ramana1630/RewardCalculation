# RewardCalculation
Customer Reward Calculation
- The package name is structured as com.rewards.customer
- Exception is thrown if customer does not exists.
- Customers data - 101,102,103,104



-Api call
 GET - http://localhost:8080/customers/104/rewardpoints

Response :
{
"customerId": 104,
"lastMonthAmounts": [
189.0
],
"lastMonthRewardPoints": 228,
"lastSecondMonthAmounts": [
245.0,
220.0,
178.0
],
"lastSecondMonthRewardPoints": 836,
"lastThirdMonthAmounts": [],
"lastThirdMonthRewardPoints": 0,
"totalRewards": 1064
}