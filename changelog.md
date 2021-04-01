------------------------------------------------------
Version 0.1.0
------------------------------------------------------
First alpha release of Automatone, forked from Baritone 1.6.3.

**EVERYTHING IS EXPERIMENTAL AND SUBJECT TO CHANGE**

**Additions**
- Fake Player API: easily create fake players that can be commanded with Baritone
  - Fake players do not load chunks, and do not prevent other players from sleeping
- Local settings: change pathfinding settings for one entity at a time
    - If a local setting doesn't have its value explicitly set, it will use the value of the equivalent global setting

**Changes**
- All operations now runs serverside
- Clientside commands have been replaced with serverside brigadier
    - All commands must be prefixed with `/automatone`
    - Only operators can use commands
- Operators can visualize paths for any entity that is using Automatone's pathfinding
- Automatone will consider ascending through a column of water
    - this does not include bubble columns yet
- Pathfinding can now use hanging vines and scaffolding, as well as any modded climbable block
    - modded scaffolding is unlikely to work though
- Automatone should detect which modded doors cannot be opened
- Parkour movements should overshoot a bit less
- Chunk scanning for mining operations should be slightly faster
- Simple movements can now occur while the entity is looking in some other direction
- Differently sized entities are *kind of, somewhat, vaguely handled* by Automatone's pathfinding
  - entities that are smaller than a player should work as expected
  - entities that are taller than a player should more or less work
  - entities that are wider than a player fit in some rather broad definition of "working"
    - they do not fit in any definition of "good" though

**Fixes**
- Fixed a crash when an entity fell into the void while pathfinding
- Fixed a crash when a player attempted to auto-build with ladders in their inventory
- Automatone will no longer attempt to place water buckets in `ultrawarm` dimensions
- Pathfinding will now consider the speed modifiers on any block, not just soulsand
- WIP: some moves should now work with varying player sizes
- Players will no longer attempt to mine or place blocks in protected areas

**Removals**
- Removed cheating