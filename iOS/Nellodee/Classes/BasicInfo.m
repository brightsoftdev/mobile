//
//  BasicInfo.m
//  Nellodee
//
//  Created by Ada Hopper on 17/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "BasicInfo.h"


@implementation BasicInfo

@synthesize username, email;
@synthesize firstName, lastName, prefName;
@synthesize rol, departament, college;
@synthesize tags;

/*
// A method to convert an enum to string
NSString* rolTypeStringToEnum( RolType enumVal )
{
    NSArray *rolTypeArray = [[NSArray alloc] initWithObjects:RolTypeArray];
    return [rolTypeArray objectAtIndex:enumVal];
}

// A method to retrieve the int value from the NSArray of NSStrings
RolType rolTypeEnumToString(NSString* strVal)
{
    NSArray *rolTypeArray = [[NSArray alloc] initWithObjects:RolTypeArray];
    NSInteger n = [rolTypeArray indexOfObject:strVal];
    if(n < 0){
        n = Other;
    }
    return (RolType) n;
}
*/


@end
