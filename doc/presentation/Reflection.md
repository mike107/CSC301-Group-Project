## What tools/techniques/conventions worked well for your team and why?

The tool that helped us the most was using the Backendless platform for things like our backend database and low-level features such as user authentication and signup. This saved us the time we would’ve spent on low-level features such as setting up a backend database or user signup and enabled  us to spend more time on implementing the key features of our app.

A convention that worked well for us was our choice of using the common and simple but effective progressive-stability branching for our git workflow. A stable build of our application was always available in the master branch. We had a parallel “develop” branch for testing. When the develop branch was stable we would merge it into master. We’d create topic branches off develop for any features and bugs we were working on that were either named feature/<feature> or bug/<bug> respectively. This helped us organize and manage our tasks and code and made sure we always had a stable build of code in the master branch.

## What tools/techniques/conventions didn't work well for your team and why?

Rather than a convention that didn’t work well for our team, it was a lack of any strict coding conventions. Our rationale was that it would be easier for each person to code if they stuck to coding in their own personal style. In hindsight, this decision resulted in unorganized and confused code. Since we’ve spent far more time reading our code than writing it, the fact that our code is not easy to read greatly reduced our productivity.

Despite the fact our git workflow helped us organize and manage our code, it became a double-edged sword due to a lack of proper maintenance. This was mainly due to the fact that each team member had discretion to create a topic branch which lead to a proliferation of branches. Although our productivity wasn’t impacted in the moment, it was easy to see how the issue could negatively affect us the longer we work on the application.

## How would you redesign your process?

If we could redesign our process, we would definitely use a different project management tool such as Trello. We felt Pivotal Tracker was too clunky to use effectively some team members have used Trello with great effectiveness in managing their own past projects.

As mentioned before, despite our git workflow being simple and lightweight, we didn't institute appropriate conventions to maintain our repository. Therefore, we’d clearly define rules on what and how many branches we could create. We might also have one person dedicated to “curating” our Github repository to make sure it stays organized. We’d also create a .gitignore file at the beginning of development and update it when necessary.

Lastly, we would choose a single coding style guide for the team to follow. We would probably end up utilizing one of the more popular style guides such as the Google Java style guide.

