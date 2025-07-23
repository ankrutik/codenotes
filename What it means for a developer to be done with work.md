#coding/bestpractices 

_What it means for a developer to be "done" with a JIRA ticket..._

- Code complete
- Self reviewed
- Tested
    - functional testing of all use cases
    - check upgrade logs for errors
    - check application logs for errors
    - _think of how your new changes will be applied to prod environment_
- PR created and presented for review
- PR peer reviewed, approved, and merged
- Code deployed to a test environment
- Changes verified by developer on above test environment
- Only after above, a JIRA ticket will be resolved by developer, meaning sent to QA

_Motivation here to save QA's time in what developers can catch at their end itself._ 

_Treat QA environments as sacrosanct spaces where ideally no errors and bugs should fall thru._

_When to use commit amend?_ 

While you have not created and published a PR.

_After PR is published and changes are requested..._

create **new commit for every change** to you present for review thru PR.

Squash the commits into a single commit only if someone explicitly asks for that and make sure to do that only after the PR is approved and ready to merged.

_Motivation here is to save review time. If you have changes in 25 files and PR comments ask for changes in 2 files, commit amend will force the reviewer to go thru 25 files again._