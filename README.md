# Portfolio-Status
Sends a text message at the end of every trading day, showing the status of a portfolio and the breakdown of individual positions.

Having self studied and invested for over three years with success in the stock market; my parents entrusted me with some money that they wanted to see grow. They would ask me almost every day how their investments were doing. I would advise them not to go down that rabbit hole as emotions of seeing large losses or large gains can take control and make you act irrationally. Despite my warnings, they would bug me asking about the status of their holdings. So I created this project that sends an automated message using the Twilio communications service and the Yahoo Finance API.

The main issue I ran into while creating this project was the risk of security. After looking for some solutions I raelize that the best path would be to store critical information such as phone numbers, stock tickers, and buy prices as System variables. That way, my information isn't accessible irectly, since its only stored on my device, and any other users can use this program by simply storing their own variables locally.
