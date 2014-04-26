import Data.List (intersperse)
import System.Environment (getArgs)
import System.IO

main :: IO ()
main = do arg <- head getArgs
          size <- read arg :: Int
          putStrLn . makeEPIC . liftIO . size

liftIO :: IO a -> a
liftIO (IO ()) = 0
liftIO (IO a)  = a

-- | make a single block
makeBlock :: Int -> String -> String
makeBlock n = concat . take n . repeat

-- | make a XXXXX block
makeType1 :: Int -> String -> String
makeType1 n = makeBlock 5 . makeBlock n

-- | make a X____ block
makeType2 :: Int -> String -> String
makeType2 n letter = text ++ spaces
  where text   = makeBlock n letter
        spaces = makeBlock (4 * n) " "

-- | make a X___X block
makeType3 :: Int -> String -> String
makeType3 n letter = concat [text, spaces, text]
  where text   = makeBlock n letter
        spaces = makeBlock (3 * n) " "

-- | make a __X__ block
makeType4 :: Int -> String -> String
makeType4 n letter = concat [spaces, text, spaces]
  where spaces = makeBlock (2 * n) " "
        text   = makeBlock n letter

-- | make letter
makeLetter :: Int -> String -> [(String -> String)] -> String
makeLetter n letter makeFuncs = join "\n" expandRows 
  where rows       = zipWith id makeFuncs . repeat $ letter
        expandRows = map (join "\n"  . take n . repeat) rows

-- | make an E
makeE :: Int -> String
makeE n = makeLetter n "E" makeFuncs
  where makeFuncs = [ makeType1 n  -- XXXXX
                    , makeType2 n  -- X____
                    , makeType1 n  -- XXXXX
                    , makeType2 n  -- X____
                    , makeType1 n  -- XXXXX
                    ]
 
-- | make an P
makeP :: Int -> String
makeP n = makeLetter n "P" makeFuncs
  where makeFuncs = [ makeType1 n  -- XXXXX
                    , makeType3 n  -- X___X
                    , makeType1 n  -- XXXXX
                    , makeType2 n  -- X____
                    , makeType2 n  -- X____
                    ]

-- | make a I
makeI :: Int -> String
makeI n = makeLetter n "I" makeFuncs
  where makeFuncs = [ makeType1 n  -- XXXXX
                    , makeType4 n  -- __X__
                    , makeType4 n  -- __X__
                    , makeType4 n  -- __X__
                    , makeType1 n  -- XXXXX
                    ]

-- | make a C
makeC :: Int -> String
makeC n = makeLetter n "C" makeFuncs
  where makeFuncs = [ makeType1 n  -- XXXXX
                    , makeType2 n  -- X____
                    , makeType2 n  -- X____
                    , makeType2 n  -- X____
                    , makeType1 n  -- XXXXX
                    ]

-- | make new lines
makeNewLines :: Int -> String
makeNewLines n = makeBlock n "\n"

-- | make epic
makeEPIC :: Int -> String
makeEPIC 0 = "EPIC"
makeEPIC n = join (makeNewLines n) . epic $ n
  where epic = zipWith id [makeE, makeP, makeI, makeC] . repeat

-- | repeat the row scale times
expandRows :: Int ->  String -> String
expandRows n = join "\n" . take n . repeat

-- | join strings with delimiter
join :: [a] -> [[a]] -> [a]
join delim = concat . intersperse delim
