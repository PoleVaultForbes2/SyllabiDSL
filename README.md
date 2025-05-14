<meta charset="utf-8" lang="en">

                **Syllabi_DSL_README**




Author
=============

<!-- Note: wrapping table in div.noheader will hide the table's header -->
<!-- Note: wrapping table in div.firstcol will style the first column different from other columns -->
Josh Forbes and Matthew Saxby


Overview
================
SyllabusDSL is a domain-specific language for converting course syllabi into structured, color-coded HTML calendars. 
Users can declare course assignments, tests, projects, breaks, and difficulty levels in a concise format. 
The output includes due dates, automatic reminders based on difficulty, and a visual semester layout.

DSL Grammar  
-----------------------
- **Difficulty mapping**: e.g., `2:1` means difficulty 2 gives a 1-day reminder
- **Semester dates**: for determining calendar range
- **Breaks**: highlighted ranges that have extra reminder
- **Courses** with categories (`HOMEWORK`, `PROJECTS`, `TEST`)
- **Assignments** with title, date, optional difficulty, and optional color

Example DSL Program
-----------------------
~~~~~~~~~~~~~~~~~~~~
DIFFICULTY LEVEL: 2:1 3:2 4:3

BREAKS: (11/25/2025 - 11/29/2025)

SEMESTER DATES: (08/21/2025, 12/15/2025)

COURSE CS101:
HOMEWORK: ("HW1", 09/01/2025, 2, red)
PROJECTS: ("Project Alpha", 10/10/2025, 4, blue)
TEST: ("Midterm", 11/13/2025, 3, green)

COURSE MATH204:
HOMEWORK: ("Worksheet 1", 08/25/2025, 1, red)
TEST: ("Final", 12/10/2025, 4, green)
~~~~~~~~~~~~~~~~~~~~

Here we can see the first thing inputed is the DIFFICULTY LEVEL which will map the difficulty as the first item and the number of days for a reminder as the second.
The next item is the BREAKS which are specific dates during the semester.
Next is the SEMESTER DATES which is the range of the semester.
Followed by all the courses. Here we have a label for the course and then the following assignmetns. Assignment can either be "HOMEWORK", "PROJECTS", or "TEST".
Each assignment has the structure of (name, date, optional difficulty, optional color). The color will be overriden if it is due during a break in which case is yellow as an extra reminder.

**This program correctly generates an HTML calendar with:**

- Red entries for homework, blue for projects, green for tests

- Reminder events offset by difficulty

- Breaks rendered in yellow with no reminders during that span

- Date placement confirmed with semester boundaries

**Output for this input**

![Output based on Input](test.png width="600px")
![Another month with breaks](testBreaks.png width="600px")


DSL vs General Purpose
-----------------------
A Domain-Specific Language (DSL) is a powerful tool designed to simplify the process of accomplishing a particular task. While a general-purpose programming language could technically achieve the same results, doing so would require significantly more effort and programming expertise. In contrast, this DSL is tailored specifically for mapping syllabus data to a calendar, making it much more approachable for users who may not have a background in software development. The strength of a DSL lies in its focused simplicity—it allows users to describe their data and intentions in a clear, readable format without needing to understand complex syntax, data structures, or control flow. 

Who did What???
-----------------------
Josh: Mainly worked on the grammar and the data extraction from the visitor as well as properly finishing the html file and readme
Matthew: Handled coming up with inputs, building the HTML file, helping come up with better grammar rules



<!-- ****************************** -->
<!--    Leave the content below     -->
<!-- ****************************** -->

<!-- The script and style below are added for clarity and to workaround a bug 
<script>
    // this is a hack to workaround a bug in Markdeep+Mathjax, where
    // `&#36;`` is automatically converted to `\(`` and `\)`` too soon.
    // the following code will replace the innerHTML of all elements
    // with class "dollar" with a dollar sign.
    setTimeout(function() {
        var dollars = document.getElementsByClassName('dollar');
        for(var i = 0; i < dollars.length; i++) {
            dollars[i].innerHTML = '&#' + '36;'; // split to prevent conversion to $
        }
    }, 1000);
</script>
<style>
    /* adding some styling to <code> tags (but not <pre><code> coding blocks!) */
    :not(pre) > code {
        background-color: rgba(0,0,0,0.05);
        outline: 1px solid rgba(0,0,0,0.15);
        margin-left: 0.25em;
        margin-right: 0.25em;
    }
    /* fixes table of contents of medium-length document from looking weird if admonitions are behind */
    .md div.mediumTOC { background: white; }
    .md div.admonition { position: initial !important; }
</style> -->

<!--   Leave the following Markdeep formatting code, as this will format your text above to look nice in a wed browser 
<style class="fallback">body{visibility:hidden;white-space:pre;font-family:monospace}</style>
<script src="https://casual-effects.com/markdeep/latest/markdeep.min.js"></script>
<script>window.alreadyProcessedMarkdeep||(document.body.style.visibility="visible");</script> -->
