# The script of the game goes in this file.


# Declare characters used by this game. The color argument colorizes the
# name of the character.

define a = Character("Al", color="#D3D3D3")
define h = Character("Henry", color="#F0E2B6")
define m = Character("Marie", color="#000080")
define s = Character("Sophie", color="#006400")
define t = Character("Tommy", color="#964B00")
define ath = Character("Al's Thoughts", color="#D3D3D3")

# The game starts here.

label start:

    # Show a background. This uses a placeholder by default, but you can
    # add a file (named either "bg room.png" or "bg room.jpg") to the
    # images directory to show it.

    image BG room r="BG room.png"

    scene BG room r with dissolve

    # This shows a character sprite. A placeholder is used, but you can
    # replace it by adding a file named "eileen happy.png" to the images
    # directory.

    show ath athNormal


    # These display lines of dialogue..

    ath "It is a Friday like all others before it."
    ath "Marie and Sophie, my close friends, in fact my only friends have come to my house to study again."


    hide ath

    show s sExplain

    s "I don’t get this exercise."

    hide s

    show m mNormal

    m "You need to use the new formula we learned not the old one."

    hide m

    show ath athNormal

    ath "Another boring and calm Friday. Halloween in two days yet no plans. Maybe I should ask them to do something."

    hide ath

    show a aNormal

    a "Will we guys do anything for Halloween? Like maybe watch a movie or something?"

    hide a

    show m mNormal

    m "If we are going to gather together I think it would be best if we just study."

    hide m

    show ath athNormal

    ath "That’s boring but she is right, not like we do anything else anyway."

    hide ath

    show s sExplain

    s "Actually…"

    hide s

    show a aExplain

    a "What is it?"

    hide a

    show s sExplain

    s "Henry and Tommy invited us to hang out with them this Halloween. Can you guys come?"

    hide s

    show m mNormal

    m "Of course not, I don’t like spending time with those two. They are too easy going for my taste."

    hide m

    show ath athNormal

    ath "Marie is right but I kinda wanna go too."

    hide ath

    show s sExplain

    s "Please guys can we go???"

    hide s

    show ath athNormal

    ath "I mean, Tommy and Henry are nice guys but we don’t really hang out so I don’t think it would be a good idea."

    hide ath

    show s sExplain

    s "Can you please do it for me?"

    hide s

    show m mNormal

    m "Why are you so eager to hang with them?"

    hide m

    show ath athNormal

    ath "Sophie stays silent for a while."

    hide ath

    show s sExplain

    s "It’s because…because I like Tommy… and I want to confess to him!"

    hide s

    show ath athNormal

    ath "Oh yeah, I completely forgot she has liked him for years."

    hide ath

    show ath athNormal

    ath "Al sighs."

    hide ath

    menu:
        "Should i stay home or go?"

        "Stay at home.":

            show a aExplain

            a "Let’s stay at home and study."

            hide a

            jump home

        "Decide to go.":

            show ath athNormal

            ath "Okay. Let’s go."

            hide ath

    show m mNormal

    m "Since Al is coming then I’ll come too."

    hide m

    show s sNormal

    s "Thank you so much guys!"

    hide s

    show m mNormal

    m "Let’s continue our studies for now."

    hide m

    image BG road ro="BG road.png"

    scene BG road ro with dissolve

    show ath athNormal

    ath "Well, here we are on the road to the forest waiting for Tommy and Henry. Maybe this was a bad idea."

    hide ath

    show s sExplain

    s "I’m so excited."

    hide s

    show m mNormal

    m "Ugh."

    hide m

    show ath athNormal

    ath "Okay maybe it wasn’t so bad of an idea.Ah…Here is Tommy and Henry."

    hide ath

    show t tNormal

    t "Hi guys! I’m so glad you all came.
    Me and Henry were a little worried it wouldn’t be so much fun if it was only the two of us."

    hide t

    show h hNormal

    h "Yep. The more the merrier! I’ve heard so much avout this mainsion can’t wait to go in."

    hide h

    show m mNormal

    m "I have also heard much and I’d rather stay away but well…"

    hide m

    show ath athNormal

    ath "We began walking, Sophie got closer to Tommy but he doesn’t seem to pay any attention to her."

    hide ath

    show h hExplain

    h "I heard that the family who used to live here were all brutally murdered in their sleep years ago."

    hide h

    show t tExplain

    t "They say that the ghosts of the members still lurk around in hopes of revenge."

    hide t

    show m mNormal

    m "They say that if you find the lady’s portrait it will smile back at you and follow with her eyes."

    hide m

    show s sExplain

    s "That sounds scary I wonder if it’s true."

    hide s

    show t tNormal

    t "We’ll find out soon enough!"

    hide t

    show ath athNormal

    ath "Honestly those all sound like made up stories but I hope we have a good time."

    hide ath

    show a aNormal

    a "Do you guys have anything planned for when we go there or will we just wander around."

    hide a

    show t tExplain

    t "Yes! We actually got a pretty good idea. Henry show them!"

    hide t

    show ath athNormal

    ath "Henry opens up his backpack to reveal a present."

    hide ath

    show h hPresent

    h "My mom prepared this, actually neither of us has any idea what’s in it, however it probably is something good."

    hide h

    show ath athNormal

    ath "Henry and Tommy are smiling at us but I don’t get what’s happening. Sophie and Marie also look confused fortunately."

    hide ath

    show t tNormal

    t "To explain; we’re gonna leave the present near the door and then each of us will head of to a different direction. If you get scared or spooked you return to the door and wait for the others."

    hide t

    show h hNormal

    h "The last to return will win the gift!"

    hide h

    show m mNormal

    m "I’m not sure it's a good idea for everyone to head alone."

    hide m

    show t tExplain

    t "Oh come on! Nothing bad will happen!"

    hide t

    show ath athNormal

    ath "As if on cue we arrived at the house."

    hide ath

    image BG entrance e="BG entrance.png"

    scene BG entrance e with dissolve

    show ath athNormal

    ath"Tommy takes the gift Henry got and puts it next to the wooden kind of rotten house door."

    hide ath

    show t tExplain

    t "Now that this is done we have to decide who will go first!"

    hide t

    show h hNormal

    h "Yes! Let’s go. I’ll win for sure!"

    hide h

    show m mNormal

    m "I have a question."

    hide m

    show t tExplain

    t "What is it?"

    hide t

    show m mNormal

    m "How do we know we aren’t going in the same direction the person before us went to?"

    hide m

    show h hNormal

    h "…"

    hide h

    show h hNormal

    h "You’re right…hmmmmm."

    hide h

    show t tExplain

    t " I say we leave it to fate! If we go in the same direction then it was meant to be!"

    hide t

    show s sNormal

    s "Sounds good for me!"

    hide s

    show a aExplain

    a "Fine by me too."

    hide a

    show m mNormal

    m "Ugh… okay."

    hide m

    show ath athNormal

    ath "A few moments pass in silence."

    hide ath

    show t tExplain

    t "I wanna go first!"

    hide t

    show h hExplain

    h "No I will go first!"

    hide h

    show t tNormal

    t "You know it doesn’t matter right?"

    hide t

    show h hNormal

    h "Yes, precisely so let me go first!"

    hide h

    show t tExplain

    t "Fine, fine. You're always obsessed with going first."

    hide t

    show s sExplain

    s "I’ll go after Tommy."

    hide s

    show ath athNormal

    ath "Oh… she will probably follow him."

    hide ath

    show m mNormal

    m "Well I want to be last."

    hide m

    show a aNormal

    a "Guess that makes me 4th."

    hide a

    show ath athNormal

    ath "Henry heads in first, then Tommy waits a few minutes before going in. I notice Sophie is checking where Tommy goes from the windows. Then she goes next. I sigh."

    hide ath

    show a aNormal

    a "Well then Marie I’m going in."

    hide a

    show m mNormal

    m "Okay…"

    hide m

    image BG stairs b="BG stairs.png"

    scene BG stairs b with dissolve

    show ath athNormal

    ath "I finally head into the house. The wooden floor creaks under my legs. There are some huge stairs in te middle but they don’t look sturdy. I’ll enter one of the rooms in this floor."

    hide ath

    menu:
        "Should i go to the left or the right?"

        "Go to the right.":
            image BG portrait p="BG portrait.png"

            scene BG portrait p with dissolve

            show ath athNormal

            ath "I enter the huge room. It’s almost empty, moonlight illuminates the room through the broken windows. I notice a portrait."

            ath "I go closer, it’s a portrait of a lady, shivers go down my spine."

            ath "I better go through the other room."


        "Go to the left.":

            image BG library lib="BG library.png"

            scene BG library lib with dissolve

            show ath athNormal

            ath "I enter the room. There is a huge library. Well then I better look at this books for a while."

    ath "The door opens. I get scared for a second but then notice Marie."

    hide ath

    show m mNormal

    m "Thank God you’re the one here."

    hide m

    show ath athNormal

    ath"She looks around and starts looking at the books with me. After a while a loud noise is heard, like something falling down."

    hide ath

    show a aExplain

    a "Do we go check?"

    hide a

    show m mNormal

    m "…okay."

    hide m

    show ath athNormal

    ath "Marie grabs my arm as we go out and see Sophie looking distraught."

    hide ath

    show s sNoExplain

    s "Oh hi guys. Did you hear that loud noise?"

    hide s

    show a aNormal

    a "Yes we were just going to check."

    hide a

    show s sNo

    s "Can I come with you I’m scared?"

    hide s

    show a aNormal

    a "Sure let’s go."

    hide a


    show ath athNormal

    image BG stairs b="BG stairs.png"

    scene BG stairs b with dissolve

    ath "We walk around the first floor trying to find out what happened but we saw nothing."

    hide ath

    show m mNormal

    m "I think we have to go upstairs."

    hide m

    show s sNo

    s "…"

    hide s

    show a aNormal

    a "Yeah let’s go…"

    hide a

    show ath athNormal

    ath "We continue walking going to the second floor. As we get near a door we hear another loud noise and then someone crying."

    hide ath

    show ath athNormal

    ath "Marie and Sophie look at each other scared."

    hide ath

    show a aNormal

    a "I’ll go in first…"

    hide a

    image BG deadTommy dt="BG deadTommy.png"

    scene BG deadTommy dt with dissolve

    show ath athNormal

    ath "I open the door. Henry is on his knees crying I go over to him. As I touch his shoulder I notice Tommy lying next to the wall covered in blood."

    hide ath

    show a aScared

    a "What happened?!"

    hide a

    show h hCry

    h "I don’t know I just found him like this…"

    hide h

    show ath athNormal

    ath "I hear screams behind me and see Sophie scream. I turn my head back to Tommy’s body and notice some white beads next to the blood…"

    hide ath

    show s sScared

    s "D-Did you kill him?"

    hide s

    show h hCry

    h "What! I would never do that, I just found him here."

    hide h

    show ath athNormal

    ath "Marie goes behind Sophie and looks scared."

    hide ath

    menu:
        "Should i trust Sophie?"

        "Trust Sophie":

            show a aExplain

            a "Al: Sophie’s right, the three of us were together only you could have done something to him."

            hide a

            jump bad_end

        "Talk back at Sophie":

            show a aExplain

            a "I don’t think he did it… they were best friends he has no reason."

            hide a

    show m mScared

    m "That is true…"

    hide m

    show s sScared

    s "But what happened then??"

    hide s

    show ath athNormal

    ath "I don’t want to admit this but…"

    hide ath

    show a aExplain

    a "Sophie you did it."

    hide a

    show s sAngry

    s "What?!"

    hide s

    show ath athNormal

    ath "Henry and Marie look between me and Sophie confused."

    hide ath

    show a aExplain

    a "I saw you following Tommy when you entered the house… you were going to confess to him were you not?"

    hide a

    show s sNoExplain

    s "Yes but I lost him and then came to you guys as I cousln’t find him."

    hide s

    show a aExplain

    a "So you say but your necklace’s beads are all around Tommy’s body."

    hide a

    show s sScared

    s "…"

    hide s

    show ath athNormal

    ath "Sophie looks at me and then runs away."

    hide athNormal

    show m mScared

    m "What do we do?"

    hide m

    show h hExplain

    h "We should call the police or the ambulance maybe Tommy can be saved."

    hide h

    image BG new_menu nm="BG new_menu.png"

    scene BG new_menu nm with dissolve

    show ath athNormal

    ath "We do as Henry said. The police came they couldn’t find Sophie at first but Tommy was rushed to the hospital."

    ath "Sophie was found and captured a few days later. She confessed to pushing him into broken glass after he refused to date her."

    ath "Tommy was saved but hasn’t woken up yet."

    ath "Everything feels so weird."

    hide ath

    "GOOD ENDING"

    return


    label home:

            show s sNormal

            s "Okay then..."

            hide s

            show m mNormal

            m "Perfect for me."

            hide m

            "The three of them spend the weekend studying peacefully."

            return

    label bad_end:

            show m mExplain

            m "Yeah and you guys are always having competitions together, maybe you didn’t like him much…"

            hide m

            show h hCry

            h "What the hell he was my best friend! Why would I do that?"

            hide h

            show ath athNormal

            ath "We can’t trust him this is dangerous."

            hide ath

            show a aExplain

            a "Sophie, Marie we have to go and call the police."

            hide a

            show ath athNormal

            ath "We run not letting Henry come after us and call the police when we are far enough."

            ath "The police holds an investigation. Henry was not guilty…"

            "BAD ENDING"

            return
